import numpy as np 
import pandas as pd
from sklearn.utils import shuffle
from sklearn.ensemble import RandomForestRegressor
from sklearn.model_selection import train_test_split

data =pd.read_csv("./data/ML_Assembled PC.csv")
df_purpose = pd.read_csv("./data/target.csv")
y = df_purpose.drop(['최저가','용도','Unnamed: 0'],axis=1)
X = pd.DataFrame(df_purpose,columns = ['최저가','용도'])

X_train, X_test, y_train, y_test = train_test_split(X,
                                                    y,
                                                    test_size=.25,
                                                    random_state=42)

model=  RandomForestRegressor(n_estimators = 1000,
                           max_depth= 80,
                           max_features=2,
                          min_samples_leaf = 2)

model.fit(X_train, y_train)

data = pd.DataFrame(data,columns =['CPU 제조사', 'CPU 넘버', '메모리 타입', '메모리 용량', 'SSD 형태', 'SSD 용량', '그래픽 칩셋',
       '그래픽 메모리', '운영체제', 'CPU Score', 'GPU Score', '용도', '최저가', '제품명',
       '그래픽 제조사', '저장장치1', '저장장치2', '저장장치1 크기', '저장장치2 크기','제품 코드'])

predict_columns = ['CPU 제조사', '그래픽 제조사', '메모리 용량', '저장장치1 크기', '저장장치2 크기', '운영체제',
       'CPU Score', 'GPU Score', 'DDR3L', 'DDR4', 'DDR5',
       'GDDR6', 'LPDDR4', 'LPDDR5', '1_M.2',
       '1_SSD', '1_eMMC', '1_mSATA', '2_M.2', '2_SSD',
       '2_eMMC', '2_mSATA']



def find_best(target_dict):

    target_df = pd.DataFrame(target_dict)
    
    predict_df = pd.DataFrame(model.predict(target_df),columns = predict_columns)
    df_best  = data
    df_best = df_best.astype({'최저가':'int64'})
    
    
    cpu_score = predict_df['CPU Score'][0]
    gpu_score = predict_df['GPU Score'][0]
    memory = round(predict_df['메모리 용량'][0])
    cpu_from = round(predict_df['CPU 제조사'][0])
    gpu_from = round(predict_df['그래픽 제조사'][0])
    os = round(predict_df['운영체제'][0])
    storage1 = round(predict_df['저장장치1 크기'][0])
    storage2 = round(predict_df['저장장치2 크기'][0])
    price = target_df.iloc[0,0]
    
    df_best = df_best.loc[df_best['CPU 제조사'] == cpu_from]
    df_best = df_best.loc[df_best['그래픽 제조사'] == gpu_from]

    for i in range(8,14):
    
        if predict_df.iloc[:,i][0] >= 0.5:
        
            memory_type = predict_columns[i]
            break
        
        else:
            memory_type = ""
        
    for i in range(14,18):
    
        if predict_df.iloc[:,i][0] >= 0.5:
        
            storage1_type = predict_columns[i]
            break
        
        else:
            storage1_type= ""
        
    for i in range(18,22):
        
        if predict_df.iloc[:,i][0]:
        
            storage2_type = predict_columns[i]
            break
        
        else:
            storage2_type= ""
            
            
    
    df_best.loc[:,'CPU Score'] = abs(df_best.loc[:,'CPU Score']-cpu_score)
    df_best.loc[:,'GPU Score'] = abs(df_best.loc[:,'GPU Score']-gpu_score)
    df_best.loc[:,'최저가'] = abs(df_best.loc[:,'최저가']-price)
    
    
    best_product = df_best.sort_values(['최저가','GPU Score','CPU Score']).head(5).reset_index(drop=True).loc[0,'제품 코드']
    
    
    return data.loc[data['제품 코드'] == best_product].reset_index(drop=True).to_dict('records')
    
    
