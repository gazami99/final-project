from package import MLSerivce

def mlService():
  
  test_dict = {'최저가':700000,'용도':0}
  ml_dict = MLService(test_dict)
  
  assert ml_dict.keys() != None
  
  
