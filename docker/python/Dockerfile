
FROM python:3.8

WORKDIR /usr/src/app 

COPY requirments.txt .

RUN pip install -r requirments.txt

COPY src/ .

ENTRYPOINT ["python","./server.py"]
