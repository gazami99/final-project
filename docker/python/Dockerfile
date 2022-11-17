
FROM python:3.8

COPY Python-deploy/ .

RUN pip install -r Python-deploy/requirements.txt .

ENTRYPOINT ["python","/app.py"]


