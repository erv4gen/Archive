lg <- function(mu,n,ybar) {
	mu2 <- mu^2
	return(n * (ybar *mu - mu2/2) - log(1.0 +mu2))
}

mh <- function(n,ybar,n_iter, m_init,cand_sd) {
	mu_out = numeric(n_iter)
	accept = 0
	mu_now = mu_init
	lg_now = lg(mu=mu_now,n=n,ybar)
	
	for(i in 1:n_iter) {
		mu_cand = rnorm(1,mean=mu_now,sd=cand_sd)	
		lg_cand = lg(mu=mu_cand,n=n,ybar=ybar)
		
		lalpha = lg_cand - lg_now
		alpha = exp(lalpha)

		u = runif(1)
		if(u <alpha) {
			mu_now = mu_cand
			accpt = accpt +1
			lg_now = lg_cand
		}
		mu_out[i] = mu_now
	
	}
	list(mu=mu_out,accpt=accpt/n_iter)
	
}