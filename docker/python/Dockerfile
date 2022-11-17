
FROM python:3.8

RUN apt-get update
RUN apt-get install locales -y
ENV LANG ko_KR.UTF-8
ENV LANGUAGE ko_KR.UTF-8
RUN update-locale LANG=ko_KR.UTF-8


COPY Python-deploy/ .

RUN pip install -r requirements.txt

ENTRYPOINT ["python","/app.py"]


