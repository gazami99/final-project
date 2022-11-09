# 파이널 프로젝트
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
<img src="https://github.com/gazami99/final-project/blob/main/image/finalproject.png">
</div>


## 팀원:
	
	엄호용 << 
  	박정민 << 개고수
  	박아름샘 << 자칭 라푼젤
  	성광식 <<


## 변경사항
### 2022.10.02 

	github action maven evn 셋팅완료
	merge 요청 승인  
	
### 2022.10.10
	
	@SpringBootApplication(scanBasePackages= {"kr.pe.cshop.model.service.MemoryCardService"}) << 스캔 실패해서 명시적으로 표현함 
	SpringBootTest 자꾸 에러나서 경로 변경함 io.playdata > kr.pe.cshop
	
### 2022.10.25

	Github action Delpoy ECR 등록 성공(maven build 확장자가 war라서 Dockerfile 세팅에서 jar를 war로 바꾸니 작동됨 )
	
### 2022.10.30
	
	k8s metric server  api server FailedDiscoveryCheck 해결(Client.Timeout exceeded while awaiting headers)
	컨테이너화된 조건으로 metric server 가 통신함 (포트 4443) 그래서 ec2에 포트 4443 열어줘야함
	
### 2022.11.2
	
	argocd 에러를 고치다가 중대한 사항을 발견함 
	"Unable to create application: application spec for guestbook is invalid: InvalidSpecError: repository not accessible: repo client error while testing 	repository: rpc error: code = Unavailable desc = connection error: desc = "transport: Error while dialing dial tcp: lookup argocd-repo-server: i/o timeout"
	
        애초에 포드간 통신이 되지 않음을 발견 이유를 보니 ec2 ubunut 환경에서 ping으로 노드간 통신결과 aws 방화벽으로 막혀있음
        해결방안 ICMP로 보안그룹을 허용해주면 해결 (같은 그룹이니 한개만 편집하면 가능) 10.30 문제고 4443 열지 않아도 될것으로 보임
        서브넷 노드간 통신이 안되어도 kubejoin이 가능햇던이유 :  통신가능한 포트만 열어줘서 가능했던것
	
### 2022.11.3
	
        포드간 통신이 원할하지 않아 argocd가 먹통이 됨
        해결안: 일단 argocd 를 제외한 서버는 end point가 argocd-server임 리눅스 명렁어 ping이 원래 먹히질 않음 argocd 기술문서 결과 tls 인증 관련 요구
        tls 인증발급이후 원할한 통신 
	
### 2022.11.6

         스프링부트 이미지 불러올시 image crashloopbackoff error 발생imagePullPolicy 명시하지 않으면 ifnotpresent가 default 값 이라 에러값 이미지를 유지함
	 해결안: 기존에 이미지를 지우거나 imagepullpolicy : always 로 명시해서 작동되는 이미지 반영
	 
	 
### 2022.11.10

         스프링부트 이미지 넣을시 파드에서 RDS endpoint 찾지못해서 스프링부트가 부트 하지못함(개발자간 작업시 localhost로 호출하게함 )
	 해결안: 
	 1. 스프링부트 application.yml 에서 스프링부트가 자동추적 못하게 변수라벨을 더넣고 java.net으로 소켓통신메서드로 rds 수신 불가능일경우
	 강제로 에러를 일으킨다음 localhost로 라우팅하게함
	 개발자간 작업시 localhost로 호출하게함 
	 
	 2. kubernetes에 service 타입중 externalName 으로 직접 RDS endpoint를 보내도록 해줌  그리고 가끔 터지는데 coreDNS 간 충돌이 있어보임	   
	 해결안: kubectl -n kube-system rollout restart deployment coredns으로 쿠버네티스 dns 를 재시작 
	
	
## 참고사항

	1. final-project 디렉토리 push , pr 요청시 github action 트리거
	2. 코드 작성완료후 export - file system 하고 final project에 넣을것 

## 요청사항 밑에 기입 

	{이거지우고 요청넣으셈} 
	

