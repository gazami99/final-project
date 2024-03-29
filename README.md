# 파이널 프로젝트 Devops design
<div align=center>
<img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=flat&logo=Amazon Ec2&logoColor=white">
<img src="https://img.shields.io/badge/Amazon RDS-527FFF.svg?style=flat&logo=Amazon RDS&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-4479A1.svg?style=flat&logo=MySQL&logoColor=white">

</div>

<div align=center>
	<img src="https://img.shields.io/badge/Kubernetes-326CE5.svg?style=flat&logo=kubernetes&logoColor=white">
	<img src="https://img.shields.io/badge/Docker-2496ED.svg?style=flat&logo=Docker&logoColor=white">
	<img src="https://img.shields.io/badge/Github Actions-2088FF.svg?style=flat&logo=githubactions&logoColor=white">
	
	
</div>

<div align=center>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F.svg?style=flat&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/HTML5-E34F26.svg?style=flat&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/JavaScript-F7DF1E.svg?style=flat&logo=JavaScript&logoColor=white">

</div>

<div align=center>
</div>
<div align=center>
<img src="https://github.com/gazami99/final-project/blob/main/image/finalproject.drawio.png">
</div>

## 파이널 프로젝트

### 개요

컴퓨터 부품사이트 거기에 초보자들을위한 가성비 자동맞춤기능까지

### 파이널 프로젝트 팀 기획링크

	https://www.notion.so/GongO-b72f0921ed644dd4af6716f2662b8b5b


### 팀원
	spec:
	  -엄호용: General Executive Director, Backend,Frontend  #특전대대 전역 주특기 통역
	  -박정민: Devops #개(짓거리)고수
	  -박아름샘: Backend,sql # 자칭 라푼젤
	  -성광식: Python, Data Mining # 가죽공예 동물애호가

## MyActivity
	
Github Action CI/CD
{
Github Action 을 이용한 도커 빌드
빌드한 도커이미지를 ECR Private Repo 에 등록
}
	
스프링부트에서 개발자 편의성을위한 Datasource route

온프리미스환경이라 생각하고 kubeadm으로 AWS EC2위에서 쿠버네티스 환경 구축해보기

RDS 를 private subnet으로 두고 데이터 넣을때만 public subnet 처럼 행동하게 바꿔보기 (라우팅 테이블로 igw)

VPC 만들고 팀들의 EC2 접근을위한 IAM설정으로 다양한 권한 설정해보기

대쉬보드로 관리하기 편하게 argocd 사용

Ingress-nginx 사용해보기

플라스크와 스프링부트간의 MSA 확인

공인인증안된 tls 적용 https 통신

## 변경사항 및 Troubleshooting
### 2022.10.02 

	github action maven evn 셋팅완료
	merge 요청 승인  
	
### 2022.10.10
	
	@SpringBootApplication(scanBasePackages= {"kr.pe.cshop.model.service.MemoryCardService"}) << 스캔 실패해서 명시적으로 표현함 
	SpringBootTest 자꾸 에러나서 경로 변경함 io.playdata > kr.pe.cshop
	
### 2022.10.25

	Github action Delpoy ECR 등록 성공(maven build 확장자가 war라서 Dockerfile 세팅에서 jar를 war로 바꾸니 작동됨 )
	
### 2022.10.30
	
	problem: metric server error -> k8s metric server  api server FailedDiscoveryCheck 해결(Client.Timeout exceeded while awaiting headers)
	
	solution: 컨테이너화된 조건으로 metric server 가 통신함 (포트 4443) 그래서 ec2에 포트 4443 열어줘야함(hostnetwork로 지정했기 때문으로 추정)
	
### 2022.11.2

	problem: "Unable to create application: application spec for guestbook is invalid: InvalidSpecError: repository not accessible: repo client error while testing 
						repository:rpc error: code = Unavailable desc = connection error: desc = "transport: Error while dialing dial tcp:lookup argocd-repo-server: i/o timeout"
	
	solution: 포드간 통신이 되지 않음을 발견 이유를 보니 ec2 ubunut 환경에서 ping으로 노드간 통신결과 aws 방화벽으로 막혀있음
	          ICMP로 보안그룹을 허용해주면 해결 (같은 그룹이니 한개만 편집하면 가능) 10.30 문제고 4443 열지 않아도 될것으로 보임x(열여아 함 hostnetwork로 설정해서)
            서브넷 노드간 통신이 안되어도 kubejoin이 가능햇던이유 :  통신가능한 포트만 열어줘서 가능했던것 <- 2022.11.22 기점으로 이 내용은 틀림
	
### 2022.11.3
	
	problem: 포드간 통신이 원할하지 않아 argocd가 먹통이 됨
	
	solution: 일단 argocd 를 제외한 서버는 end point가 argocd-server임 리눅스 명렁어 ping이 원래 먹히질 않음 argocd 기술문서 결과 tls 인증 관련 요구
	          tls 인증발급이후 원할한 통신 
	
### 2022.11.6

	problem: 스프링부트 이미지 불러올시 image crashloopbackoff error 발생imagePullPolicy 명시하지 않으면 ifnotpresent가 default 값 이라 에러값 이미지를 유지함
	           에러값이 나온이유는 ec2 아키텍쳐가 arm64인데 도커 이미지등록은 amd64 아키텍처로 등록되어있었고 그이미지가 변하지않음
						 
	solution: 도커이미지빌드를 arm64로 바꾸고 기존에 이미지를 지우거나 imagepullpolicy : always 로 명시해서 작동되는 이미지 반영
	 
	 
### 2022.11.10

	problem: 1. 스프링부트 이미지 넣을시 파드에서 RDS endpoint 찾지못해서 스프링부트가 부트 하지못함 )
	         2. kubernetes에 service 타입중 externalName 으로 직접 RDS endpoint를 보내도록 해줌  그리고 가끔 터지는데 coreDNS 간 충돌이 있어보임	 
					 
	solution: 1. 스프링부트 application.yml 에서 스프링부트가 자동추적 못하게 변수라벨을 더넣고 java.net으로 소켓통신메서드로 rds 수신 불가능일경우
	          강제로 에러를 일으킨다음 localhost로 라우팅하게하고 개발자간 작업시 localhost로 호출하게함
		  2. kubernetes에 service 타입중 externalName 으로 직접 RDS endpoint를 보내도록 해줌  그리고 가끔 터지는데 coreDNS 간 충돌이 있어보임	   
		  kubectl -n kube-system rollout restart deployment coredns으로 쿠버네티스 dns 를 재시작
	 
### 2022.11.15

	problem: 아마존 RDS에 localhost에서 작업하던 데이터를 넣고 싶은데 subnet이 private 이라 퍼블릭엑세스 하더라도 접속 불가
	
	solution: private subnet의 정의는 인터넷라우팅이 private 으로 되어있음을 알아서 데이터작업할동안은 외부와 의 네트워크라우팅 허용
	 

### 2022.11.20

	problem: ec2 보안그룹에서 인바운드 규칙중 모든 트래픽 허용을 제거 하고 작업중 다른 노드간 클러스터 통신이 원할하지 않음을 발견
	
	solution: 각 노드들을 src/dest check disabled 하고 UDP/TCP 가아닌 ip-in-ip 로 프로토콜을 설정하면 노드간 통신이 원할해짐 (calico 통신때문인듯)
	          또 내부 통신망때문에 security group 소스끼리 묶어서 모든TCP포트개방
	 
### 2022.11.21
	
	problem: Ingress 시도중 스프릥부트가 https 응답후 http로 response 함
		
	solution: 스프링부트 application.yaml 파일에서 use-relative-redirects :true 추가 
	
### 2023.02.14
	
	Spring에 profile 추가


	
	
## 참고사항

	1. final-project 디렉토리 push , pr 요청시 github action 트리거
	2. 코드 작성완료후 export - file system 하고 final project에 넣을것 

## 요청사항 밑에 기입 

	{이거지우고 요청넣으셈} 
	

