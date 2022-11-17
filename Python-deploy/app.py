# http://localhost:5000/tospring

from flask import Flask, render_template, request
from package import MLSerivce
import json

import urllib.request

app = Flask(__name__)

@app.route('/gongo/search/keyword/<purpose>/<price>', methods=['GET'])
def spring(purpose,price):

    find_info = {'최저가':[int(price)],'용도':[int(purpose)]}
    #json.dumps(MLSerivce.find_best(find_info))
    return json.dumps(MLSerivce.find_best(find_info),ensure_ascii=False)
    


if __name__ == '__main__':
    app.run(debug=True, host="127.0.0.1",port=5000)