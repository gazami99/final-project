
FROM python:3.8

RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y 
RUN apt-get install -y apt-utils locales
RUN locale-gen ko_KR.UTF-8
ENV LC_ALL ko_KR.UTF-8

COPY Python-deploy/ .

RUN pip install -r requirements.txt

ENTRYPOINT ["python","/app.py"]


