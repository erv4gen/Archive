#%%
import pandas as pd
import matplotlib.pyplot as plt
plt.figure(figsize=(10,15))
df = pd.read_csv('res.csv')
df.plot()
