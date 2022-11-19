
# http://localhost:5000/tospring

from flask import Flask, render_template, request
import json

app = Flask(__name__)

@app.route('/gongo/search/keyword/<purpose>/<price>', methods=['GET'])
def spring(purpose,price):


    #json.dumps(MLSerivce.find_best(find_info))
    # json.dumps(MLSerivce.find_best(find_info),ensure_ascii=False)
    return "good"

@app.route('/', methods=['GET'])
def spring(purpose,price):


    #json.dumps(MLSerivce.find_best(find_info))
    # json.dumps(MLSerivce.find_best(find_info),ensure_ascii=False)
    return "good"


    


if __name__ == '__main__':
    app.run(debug=True, host="0.0.0.0",port=5000)
