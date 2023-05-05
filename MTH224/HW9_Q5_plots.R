chromium <- scan(text="34, 1, 511, 2, 574, 496, 322, 424, 269, 140, 244, 252, 76, 108, 24, 38, 18, 34, 30, 191", sep=",")
nickel <- scan(text="23, 22, 55, 39, 283, 34, 159, 37, 61, 34, 163, 140, 32, 23, 54, 837, 64, 354, 376, 471", sep=",")

pdf("Q5_Cr_Hist.pdf")
hist(chromium, main="Chromium")
dev.off()

pdf("Q5_Cr_BoxPlot.pdf")
boxplot(chromium, main="Chromium")
dev.off()

pdf("Q5_Ni_BoxPlot.pdf")
boxplot(nickel, main="Nickel")
dev.off()

pdf("Q5_Ni_Hist.pdf")
hist(nickel, main="Nickel")
dev.off()
