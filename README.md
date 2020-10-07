# 프로젝트 명 : Best Color

## 부제 : Find your Best Color



###### 상명대학교 컴퓨터과학과 캡스톤 디자인 OurFace 팀

###### 팀장 : 김지인(인공지능)

###### 팀원 : 이소현(안드로이드), 임지호(서버), 이수빈(안드로이드), 박현준(인공지능)

------



##### 1. 프로젝트 목적

- #### 사용자가 다양한 색을 테스트해 보며 자신에게 어울리는 색을 찾게 해주는 어플을 만들자





### 2. 애플리케이션 기능

- #### 사용자가 자신의 사진과 원하는 색을 선택하면 머리카락이나 입술 색을 바꿔 사진에 적용해주는 어플이다.





### 3. Best Color 애플리케이션의 효과

- #### 사용자들이 여러 색을 미리 경험할 수 있게 하여 잘 어울리는 지 스스로 판단할 수 있게 해준다.

- #### 사용자들이 자신에게 맞는 색을 찾을 수 있게 도와 섣부른 제품 구매로 인한 돈 낭비를 줄일 수 있다.





### 4. 프로젝트 설계

#### 1) 인공지능 모델

- ##### [참조 github](https://github.com/zllrunning/face-parsing.PyTorch)

- ##### 참조 모델 : YU, Changqian, et al. Bisenet: Bilateral segmentation network for real-time semantic segmentation. In: *Proceedings of the European conference on computer vision (ECCV)*. 2018. p. 325-341.

- ##### Semantic Segmentation 을 통해 얼굴에서 hair 와 lip 을 구분한다.

- ##### R,G,B 값을 통해 머리와 입술의 색을 바꿔주는 작업을 수행한다.



#### 2) 안드로이드 & 서버

<img src=".\image\diagram.png" style="zoom: 67%;" />





### 5. 결과 이미지

[Hair Before](https://github.com/ji-in/OurFace/blob/master/image/hair_before.jpg)

[Hair After](https://github.com/ji-in/OurFace/blob/master/image/hair_after.jpg)

[Lip Before](https://github.com/ji-in/OurFace/blob/master/image/lip_before.jpg)

[Lip After](https://github.com/ji-in/OurFace/blob/master/image/lip_after.jpg)



### 6. 활용방안 및 기대효과

#### 1. Lip Color

##### 브랜드 별로 다양한 립스틱이 나열되어 있으면 사용자가 원하는 립스틱을 선택하여 자신에게 어울리는지 확인해볼 수 있다. 우리 어플은 입생로랑, 맥, 샤넬, 디올 등 고가의 제품들의 색을 사용자에게 적용해볼 수 있게 만들었다. 선택만 하면 그 색을 내 사진에 적용시켜 변화된 나의 모습을 보여준다.

#### 2. Hair Color

##### 색깔 별로 여러가지 머리색이 나열되어 있다. 염색 했을 때 실패하지 않게 하기 위해 사용자는 여러가지 머리색을 적용해볼 수 있다. 

#### 3. 서비스 확장 가능성

##### 립스틱 판매 플랫폼, 또는 헤어샵 추천 플랫폼과 제휴하여 색을 추천해주는 것 뿐만 아니라 더 나은 서비스를 제공할 수 있다.