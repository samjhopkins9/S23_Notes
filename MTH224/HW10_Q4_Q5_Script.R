// Question 4
midterms <- scan(text="70, 74, 80, 84, 80, 67, 70, 64, 74, 82", sep=",")
finals <- scan(text="87, 79, 88, 98, 96, 73, 83, 79, 91, 94", sep=",")
 
mean_midt <- mean(midterms)
mean_fin <- mean(finals)
sd_midt <- sd(midterms)
sd_fin <- sd(finals)
correlation <- cov(midterms, finals)/(sd_midt*sd_fin)
b <- correlation * sd_fin / sd_midt
a <- mean_fin - b * mean_midt
cat("Regression line: y = ", a, "x + ", b, sep="")
 
chart <- lm(finals ~ midterms)
summary(chart)
plot(midterms, finals)
abline(chart)

// Question 5 --
sample <- scan(text="260, 216, 259, 206, 265, 284, 291, 229, 232, 250, 225, 242, 240, 252, 236", sep=",")
mean_sample <- mean(sample)
cat(mean_sample, "\n", sep="")
cat(var(sample), "\n", sep="")
