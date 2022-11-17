
FROM python:3.8

WORKDIR /code

ARG PYTHON_FILE=Python-deploy/

COPY ${PYTHON_FILE}

RUN pip install -r requirments.txt

ENTRYPOINT ["python","/app.py"]


