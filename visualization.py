import matplotlib.pyplot as plt

file = open("zeiten.csv", "r")
lines = file.readlines()
file.close()
# number elements
num_elem = list()
insertion_best = list()
insertion_random = list()
insertion_worst = list()
selection_best = list()
selection_random = list()
selection_worst = list()

for line in lines:
	split1 = line.split(",") # 0 = number, 1 = ins_best, 2 = ins_random, 3 = ins_worst, 4 = sel_best, 5 = sel_random, 6 = sel_worst

	num_elem.append(int(split1[0].replace("\n", "")))

	insertion_best.append(int(split1[1].replace("\n", "")))
	insertion_random.append(int(split1[2].replace("\n", "")))
	insertion_worst.append(int(split1[3].replace("\n", "")))

	selection_best.append(int(split1[4].replace("\n", "")))
	selection_random.append(int(split1[5].replace("\n", "")))
	selection_worst.append(int(split1[6].replace("\n", "")))

# visualization
plt.plot(num_elem, insertion_best, label="Insertion-Sort best case")
plt.plot(num_elem, insertion_random, label="Insertion-Sort random case")
plt.plot(num_elem, insertion_worst, label="Insertion-Sort worst case")

plt.plot(num_elem, selection_best, label="Selection-Sort best case")
plt.plot(num_elem, selection_random, label="Selection-Sort random case")
plt.plot(num_elem, selection_worst, label="Selection-Sort worst case")

plt.grid(True)
plt.xlabel("Anzahl Elemente")
plt.ylabel("Dauer in Millisekuden")
plt.title("Sortierverfahren - Laufzeitanalyse")

plt.legend(loc="upper left")
plt.show()