import cv2
import os
import numpy as np
from skimage.filters import gaussian
from test import evaluate
import argparse
from flask import Flask, render_template, request, send_file, redirect, url_for
# Flask 모듈 임포트
from werkzeug.utils import secure_filename # 파일이름의 보안 버전 반환

import base64
from io import BytesIO
from PIL import Image

global i
i = 0


app = Flask(__name__) # Flask 객체를 app에 할당


def parse_args():
    parse = argparse.ArgumentParser()
    parse.add_argument('--img-path', default='imgs/116.jpg')
    return parse.parse_args()


def sharpen(img):
    img = img * 1.0
    gauss_out = gaussian(img, sigma=5, multichannel=True)

    alpha = 1.5
    img_out = (img - gauss_out) * alpha + img

    img_out = img_out / 255.0

    mask_1 = img_out < 0
    mask_2 = img_out > 1

    img_out = img_out * (1 - mask_1)
    img_out = img_out * (1 - mask_2) + mask_2
    img_out = np.clip(img_out, 0, 1)
    img_out = img_out * 255
    return np.array(img_out, dtype=np.uint8)


def hair(image, parsing, part=17, color=[230, 50, 20]):
    b, g, r = color      #[10, 50, 250]       # [10, 250, 10]
    tar_color = np.zeros_like(image)
    tar_color[:, :, 0] = b
    tar_color[:, :, 1] = g
    tar_color[:, :, 2] = r

    image_hsv = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
    tar_hsv = cv2.cvtColor(tar_color, cv2.COLOR_BGR2HSV)

    if part == 12 or part == 13:
        image_hsv[:, :, 0:2] = tar_hsv[:, :, 0:2]
    else:
        image_hsv[:, :, 0:1] = tar_hsv[:, :, 0:1]

    changed = cv2.cvtColor(image_hsv, cv2.COLOR_HSV2BGR)

    if part == 17:
        changed = sharpen(changed)

    changed[parsing != part] = image[parsing != part]
    return changed


@app.route('/json', methods = ['GET', 'POST'])
def get_json() :
    jsonfile = request.get_json() # json 파일 받기
    print(jsonfile)

    global data_type
    global color_code_r
    global color_code_g
    global color_code_b

    data_type = jsonfile['type']
    color_code_r = int(jsonfile['ColorCode_R'])
    color_code_g = int(jsonfile['ColorCode_G'])
    color_code_b = int(jsonfile['ColorCode_B'])

    print(color_code_r)
    print(color_code_g)
    print(color_code_b)

    table = {
      'hair': 17,
      'upper_lip': 12,
      'lower_lip': 13
    }

    image_path = 'imgs/' + filename
    cp = 'cp/79999_iter.pth'

    image = cv2.imread(image_path)
    parsing = evaluate(image_path, cp)   
    parsing = cv2.resize(parsing, image.shape[0:2], interpolation=cv2.INTER_NEAREST)
    
    parts = [table['hair'], table['upper_lip'], table['lower_lip']]
    
    if(data_type=="hair"):
        hair_color = [color_code_b,color_code_g,color_code_r]
        image = hair(image,parsing,parts[0],hair_color)
    else:
        lip_color = [color_code_b,color_code_g,color_code_r]
        image = hair(image,parsing,parts[1],lip_color)
        image = hair(image,parsing,parts[2],lip_color)

    cv2.imwrite(result_path, cv2.resize(image, (512, 512)))
    return 'Success'


@app.route('/', methods = ['GET', 'POST'])
def handle_request():
   imagefile = request.files['image'] # 이미지 파일 받기

   global filename
   filename = secure_filename(imagefile.filename)
   print("\nReceived image File name : " + imagefile.filename)
   imagefile.save("./imgs/" + filename)

   global result_path
   global i
   
   result_path = 'static/' + filename + str(i) +'.png'
   i += 1

   return result_path


if __name__ == '__main__':
    app.run(host="117.16.43.105", port="8080")
