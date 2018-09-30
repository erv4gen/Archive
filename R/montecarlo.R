set.seed(32)

m = 100000
a = 2.0
b = 1.0/3.0

theta = rgamma(n=m,shape=a,rate=b)

hist(theta,freq=F)
curve(dgamma(x,shape=a,rate=b),col="blue",add=TRUE)

sum(theta/m)
mean(theta) #mean of the simulations
a/b #mean of the true value

var(theta) #sample variance of theta

a/b^2 #true variance 

#how many values is less than five in the sample
mean(theta<5.0)

#how many of thous are actually true
pgamma(q=5.0,shape =a,rate =b)

#show that values
head(theta[theta<5.0])


#show 90% quantile of the simulation
quantile(theta,probs=0.90)

#show the true .9 quantile 
qgamma(p=0.9,shape=a,rate=b)
