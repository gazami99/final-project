
FROM python:3.8

ARG PYTHON_FILE=Python-deploy/

COPY ${PYTHON_FILE}

RUN pip install -r requirments.txt

ENTRYPOINT ["python","/app.py"]
