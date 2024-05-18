import pandas as pd
import numpy as np

url = ".\Machine Learning (WIA1006)\ModifiedCrabAgePrediction.csv"
crab_df = pd.read_csv(url, header = 0)

print(crab_df.info())
print(len(crab_df))
