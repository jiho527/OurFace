# OurFace팀을 위한 간단한 github 사용법
(앞으로 계속 추가하거나 수정할 것이다)

## 참조 링크
[마크다운 사용법](https://gist.github.com/ihoneymon/652be052a0727ad59601)    
[git 간편 안내서](http://rogerdudler.github.io/git-guide/index.ko.html)    
[초심자를 위한 Github 협업](https://milooy.wordpress.com/2017/06/21/working-together-with-github-tutorial/)    
[git 설명](https://webclub.tistory.com/317)

## git에 대한 이해

이번 프로젝트에서 지호는 sever를, 소현이는 android를 맡았다. 각자 코딩을 하는데 이것을 어떻게 합쳐서 하나의 '화니 페이스'를 만들 수 있을까. 이것을 하기 위해서 지호와 소현이는 git을 사용하기로 했다.    
그래서 팀장 지인이는 'OurFace'라는 이름의 새로운 저장소(Repository)를 만들었다.    
이제 **원격**(Github 사이트)에 OurFace 저장소가 생겼다. 이제 여기에 코딩을 하기 위해 **로컬**(내 컴퓨터)에 OurFace 저장소를 다운받아야 한다.    

소현이는 먼저 git을 설치하고 **git clone {url}** 을 사용해서 저장소를 받아왔다.    

소현이는 제일 먼저 저장소에 대한 설명을 적은 README.md 파일을 만들었다. 이것을 **원격에** 올리고 싶었다.

git에 올릴 파일은 3가지 상태가 있다.
1. 포장 전인 파일들 : **Unstaged Files**
2. 포장 하기로 한 파일들 : **Staged Files**
3. 포장이 완료된 파일 묶음 : **Commit**

소현이는 **git status**를 쳐봤더니 README.md 파일이 **Unstaged 상태**인 것을 알 수 있었다.    
그래서 **git add**를 써서 그 파일을 **Staged 상태**로 바꿨다.     

그리고 소현이는 **git commit -m "README 파일추가"** 라고 쳤다. 이는 'README 파일추가'란 이름을 붙여서 선물로 포장할거라는 의미를 나타내기 위함이었다. 이렇게 코드를 **의미있는 단위로 쪼개서 포장**하는 것이 Commit이다. 각 Commit별로 변경된 이력을 편하게 볼 수 있고, 예전에 올렸던 커밋으로 코드를 돌릴 수도 있다.

이렇게 커밋만 하면 내 컴퓨터에만 저장되어 있고 **Github 사이트에는 아직 올라가지 않은 상태**였다. 이 커밋들을 진짜 원격(Github 사이트)에 올리기 위해 **git push -u origin master**를 사용했다. push를 하면 git이 우리 컴퓨터 폴더에 있는 .git 파일을 참조해서 그 곳에 저장된 OurFace 저장소 url에 코드를 올려준다. 이렇게 바로 올린 코드는 **master 브랜치**(기본 브랜치)에 올라갔다.    

## 1. 반드시 알아야 할 기본 용어

* Command Line : git 명령어를 입력할 때 우리는 커맨드 라인 인터페이스를 사용할 것이다.
* Repository(저장소) : 프로젝트가 존재하는 디렉토리나 저장 공간이다. 줄여서 "repo"라고도 한다.
* Version Control(버전 관리) : git에서는 소스 코드가 변경된 이력을 쉽게 확인할 수 있고, 특정 시          점에 저장된 버전과 비교하거나 특정 시점으로 되돌아갈 수도 있다. 
또 내가 올리려는 파일이 누군가 편집한 내용과 충돌한다면, 서버에 업로드 할 때 경고 메시지가 발생된다. 이로써 여러 명이 공유한 파일을 동시에 편집한다고 해도 다른 사람이 먼저 변경하고 있던 내용은 절대 지워지지 않는다.
* Branch : 협업시 유용한 기능이다. 작업자들은 메인 프로젝트의 브랜치를 따와서(branch off), 자신         이 변경하고 싶은 자신만의 버전을 만든다. 작업을 끝낸 후, 프로젝트의 메인 디렉토리인 master에 브랜치를 다시 merge한다.

## 2. 기본 명령어

1. Git 저장소 만들기    
    * git init : 내 컴퓨터에 폴더를 하나 만들고, 그 안에서 이 명령어를 실행하면 거기에 새로운 git 저장소가 만들어진다.
    * git clone {url} : 원격 저장소에 있는 프로젝트를 내 컴퓨터로 복제할 때 사용한다.
2. 수정하고 저장소에 저장하기    
    * git status : 파일의 상태 확인하기
    * git add <파일이름> : 파일을 새로 추적하기 - 모든 파일을 추적할 때는 git add * 사용
    * git commit -m "변경된 메시지 내용" : 변경사항 커밋하기
    * git rm : 파일을 삭제하기
    * git push -u origin master : 변경된 내용 발행하기
    
## 3. 
