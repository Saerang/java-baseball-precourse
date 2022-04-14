# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록
* 심판(컴퓨터)이 3개의 숫자를 생성한다. [Referee]  
  [] 1~9 까지 서로 다른 임의의 수 3개를 선택한다.


* 심판(컴퓨터)이 사용자의 숫자를 점검한다.
  [] 같은 수가 자리에 있으면 스트라이크  
  [] 다른 자리에 있으면 볼  
  [] 같은 수가 전혀 없으면 낫싱이란 힌트를 준다.  
  [] 3자리의 수가 맞으면 게임을 종료한다.  
  [] 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.


* 사용자가 숫자를 입력한다. [Player]  
  [] 숫자는 1~9까지 3자리 입력한다.  
  [] 잘못된 숫자를 입력하면 IllegalArgumentException 을 발생시킨 후 종료한다.  
  
  

  

