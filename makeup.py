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


@app.route('/', methods = ['GET', 'POST'])
def handle_request():
   imagefile = request.files['image']
   filename = secure_filename(imagefile.filename)
   print("\nReceived image File name : " + imagefile.filename)
   imagefile.save("./imgs/" + filename)

   table = {
      'hair': 17,
      'upper_lip': 12,
      'lower_lip': 13
   }

   image_path = 'imgs/' + filename
   print("image path는 "+ image_path)
   cp = 'cp/79999_iter.pth'

   image = cv2.imread(image_path)
   #ori = image.copy()
   parsing = evaluate(image_path, cp)
   parsing = cv2.resize(parsing, image.shape[0:2], interpolation=cv2.INTER_NEAREST)

   parts = [table['hair'], table['upper_lip'], table['lower_lip']]

   colors = [[230, 50, 20], [20, 70, 180], [20, 70, 180]]

   for part, color in zip(parts, colors):
      image = hair(image, parsing, part, color)
         
   #cv2.imwrite('/home/jiinkim/_flask/static/116_ori.png', cv2.resize(ori, (512, 512)))
   cv2.imwrite('static/116_2.png', cv2.resize(image, (512, 512)))


   #cv2.imshow('image', cv2.resize(ori, (512, 512)))
   #cv2.imshow('color', cv2.resize(image, (512, 512)))

   #cv2.waitKey(0)
   #cv2.destroyAllWindows()


   #return img_name
   return "Image Uploaded Successfully"

@app.route('/return')
def return_file():
   return render_template('template.html')


@app.route('/json', methods = ['POST'])
def get_json_file() :
   data = request.get_json()
   print(data)

   global data_type
   global color_code_r
   global color_code_g
   global color_code_b

   data_type = data['type']
   color_code_r = int(data['ColorCode_R'])
   color_code_g = int(data['ColorCode_G'])
   color_code_b = int(data['ColorCode_B'])
      
   image_data = data['image']
   image_data = bytes(image_data, encoding = "ascii")
   img = Image.open(BytesIO(base64.b64decode(image_data)))
   img.save('image.png')
   #return "Json Read"
   return redirect(url_for('upload_file'))


if __name__ == '__main__':
    app.run(host="117.16.44.14", port="8080")















