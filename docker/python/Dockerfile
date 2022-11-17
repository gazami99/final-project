
FROM python:3.8

# Dockerfile에 아래 내용 추가
# 한글 출력을 위한 패키지
RUN apt-get install locales
RUN apt-get install -y \
    language-pack-ko && \
    dpkg-reconfigure locales && \
    locale-gen ko_KR.UTF-8 && \
    /usr/sbin/update-locale LANG=ko_KR.UTF-8

# 한글을 출력하기 위해 환경변수 등록
ENV LANG=ko_KR.UTF-8
ENV LANGUAGE=ko_KR.UTF-8
ENV LC_ALL=ko_KR.UTF-8

# 파이썬에서 한글을 사용할 수 있도록 환경변수 등록
ENV PYTHONIOENCODING=UTF-8


COPY Python-deploy/ .

RUN pip install -r requirements.txt

ENTRYPOINT ["python","/app.py"]


