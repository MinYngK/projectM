/*
 * 파일명: beetle
 * 작성일: 2018.09.09
 * 작성자: 김민영
 * 5 x 5 크기의 타일로 구성된 방 안에 출발 위치에 선 딱정벌레가 한 칸씩 랜덤으로 상하좌우 이동한다.
이 때 딱정벌레가 지나간 이동 경로와 목표를 찾았는가를 알아본다.
- 출발 위치는 (0, 0)이고, 목표 위치는 타일 내에서 랜덤으로 지정한다.
- 총 20회 이동 시도 기회가 주어지며, 20번 이내에 목표위치를 찾는 경우 성공(총 시도 횟수도 출력), 찾지 못한 경우 실패임을 알린다.
   경계에 부딪쳐 이동하지 못한 것도 1회 시도로 간주한다.
- 이동 경로는 두가지로 표시한다.
 (1) 출발 위치부터 좌표 형식으로 이동경로를 표시한다.
 (2) 2차원 타일 형식으로 표시하되, 출발 위치는 S, 목표 위치는 G, 
 그 외 딱정벌레가 지나간 타일은 #, 지나가지 않은 타일은 . 으로 표시한다. 
 -- 이 출력은 마지막에 한 번만
 */
package beetle;

import java.util.Random;//랜덤함수 정의

public class Beetles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw2_1: 김민영\n");
		Random random=new Random();//랜덤 변수 random 정의
		int x=0;//이차원 배열의 행을 저장하는 변수 x
		int y=0;//이차원 배열의 열을 저장하는 변수 y
		int goal_x=random.nextInt(5);//목표 행 랜덤으로 저장
		int goal_y=random.nextInt(5);//목표 행 랜덤으로 저장
		boolean[][] beetle=new boolean[5][5];//boolean형 이차원 배열 beetle 선언, 게임의 주가 될 배열.
		int steps;//이동한 횟수를 저장하는 정수형 변수 steps 정의
		System.out.println("출발지점: ("+x+","+y+")");//출발지점 명시
		System.out.println("목표:("+goal_x+","+goal_y+")");//목표지점 명시
		System.out.print("이동경로: ("+x+","+y+") ");//이동경로를 깔끔하게 정리하기 위한 출력문 시작점과 동시 출력

		for(steps=0; steps<20; steps++) {//이동횟수를 20으로 제한하는 반복문 시작
			int direction=(int)(Math.random()*4);//한번 이동할 때 이동 방향을 정의하기 위한 Math.random을 이용한 정수형 변수 사용
			if(direction==0)//만약 direction이 0일때
				if(x==0)//그리고 x가 0일때
					x=x;//x는 x
				else//그 외의 경우에
					x--;//x를 1 줄임
			if(direction==1)//만약 direction이 1일때
				if(x==4)//그리고 x가 4일때
					x=x;//x는 x
				else//그 외의 경우에
					x++;//x를 1 줄임
			if(direction==2)//만약 direction이 2일때
				if(y==0)//그리고 y가 0일때
					y=y;//y는 y
				else//그 외의 경우에
					y--;//y를 1 줄임
			if(direction==3)//만약 direction이 3일때
				if(y==4)//그리고 y가 4일때
					y=y;//y는 y
				else//그 외의 경우에	
					y++;//y를 1 늘림

			beetle[x][y]=true;//각 경우에 따라 생성되는 x와 y를 대입하여 이동한 부분의 배열원소를 true로 정의
			System.out.print("("+x+","+y+") ");//이동한 경로 출력
			if(x==goal_x && y==goal_y)//만약 x*y번째 배열의 원소가 목표지점이면
				break;//반복문 파괴
		}

		System.out.println("\n----------");
		for(int i=0; i<5; i++) {//행을 보여줄 변수 i를 이용한 반복문
			for(int j=0; j<5; j++)  {//열을 보여줄 변수 j를 이용한 반복문
				if((i==goal_x && j==goal_y) || (i==0 && j==0)) {//목표지점이거나 출발지점일 경우
					if(i==goal_x && j==goal_y)//목표지점일 경우
						System.out.print("G");//G 출력
					else//출발지점일 경우
						System.out.print("S");//S 출력
				}
				else if(beetle[i][j]==true)//i*j번째 원소가 참일 경우
					System.out.print("#");//# 출력
				else if(beetle[i][j]==false)//i*j번째 원소가 거짓일 경우
					System.out.print(".");//. 출력
			}
			System.out.println();//행을 보기 좋게 하기 위한 줄바꿈
		}
		System.out.println("----------");

		if(steps<20)//만약 이동횟수가 20보다 작을 경우
			System.out.println("성공\r\n" + "총 시도 횟수 = "+(steps+1));//성공한 횟수와 총 시도횟수 출력
		else//그 외의 경우
			System.out.println("실패");//실패 출력
	}

}
