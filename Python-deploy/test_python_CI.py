from package.MLSerivce import findbest

def mlService():
  
  test_dict = {'최저가':700000,'용도':0}
  ml_dict = find_best(test_dict)
  
  assert ml_dict.keys() != None
  
  
