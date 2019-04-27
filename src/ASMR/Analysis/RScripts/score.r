# Analyze test scores in R
# Arguments:
#   1: The data file to analyze
#   2: The results output file
# Author: Steven Anaya

args = commandArgs(trailingOnly = T)
data.file = args[1]
results.file = args[2]
data.file = gsub("\\\\", "/", data.file)
results.file = gsub("\\\\", "/", results.file)
data.file.name = sub(pattern = "(.*)\\..*$", replacement = "\\1", basename(data.file))

test.file = readLines(data.file, n = 1)
test.results = read.csv(data.file, skip = 1)
num.tests = nrow(test.results)

test.results$Correct = factor(test.results$Correct, levels=c("no", "yes"))
test.results$Subject = factor(test.results$Subject, levels=c("no", "yes"))

plot.file.name = paste(data.file.name, "scores.png", sep = "_")
plot.path = paste(dirname(results.file), plot.file.name, sep="/")
plot.title = paste(data.file.name, "Score over Tests")

png(plot.path)
plot(c(0, test.results$Test.), c(0, test.results$Points), type = "b", main = plot.title,
     xlab = "Test #", ylab = "Points")

prop.correct = length(test.results$Test.[test.results$Correct == test.results$Subject]) / nrow(test.results)
final.score = tail(test.results$Points, n = 1)

cat("TestFile:", test.file, "\n", sep = "")
cat("NumberTests:", num.tests, "\n", sep = "")
cat("ProportionCorrect:", prop.correct, "\n", sep = "")
cat("FinalScore:", final.score, "\n", sep = "")
