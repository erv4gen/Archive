#%%
import multiprocessing as mp
import time
import pandas as pd
from tqdm import tqdm
import numpy as np

def cube_chunk(ch):
    return [x**3 for x in ch]


def cube(x):
    return x**3

def applyac_test(n):
    now = time.time()
    pool = mp.Pool(processes=4)

    Ns = np.arange(0,n)
    chunks = np.split(Ns,4)
    results = [pool.apply_async(cube_chunk, args=(x,)) for x in chunks]
    print('apply_async Tesit in ', n, ' iter')
    output  = [p.get() for p in results]
    pool.close()
    pool.join()
    return round(time.time() - now ,2)

def apply_test(n):
    now = time.time()
    pool = mp.Pool(processes=4)
    results = [pool.apply(cube, args=(x,)) for x in range(1,n)]
    print('Apply Tesit in ', n, ' iter')
    pool.close()
    pool.join()
    return round(time.time() - now ,2)


def map_test(n):
    now = time.time()
    pool = mp.Pool(processes=4)
    init = list(range(1,n))
    results = pool.map(cube, init)
    print('Map Tesit in ', n, ' iter')
    pool.close()
    pool.join()
    return round(time.time() - now ,2)



def mapac_test(n):
    now = time.time()
    pool = mp.Pool(processes=4)
    init = list(range(1,n))
    results = pool.map_async(cube, init)
    print('Map_ascync Tesit in ', n, ' iter')
    output = results.get()
    pool.close()
    pool.join()
    return round(time.time() - now ,2)



if __name__=='__main__':
    s = 1000
    l = 30000
    f = 1000
    df = pd.DataFrame(columns=['Apply','Map','Apply_Ac','Map_Ac'])
    print('Start Simulations')
    for i in tqdm(range(s,l,f)):
        df.loc[i,'Apply'] = apply_test(i)
        df.loc[i,'Map'] = map_test(i)
        df.loc[i,'Apply_Ac']=applyac_test(i)
        df.loc[i,'Map_Ac']=mapac_test(i)
    print('All work Done')
    df.to_csv('res.csv')


