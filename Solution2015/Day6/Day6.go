package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

func check(e error) {
	if e != nil {
		panic(e)
	}
}

func main() {
	dat, err := os.ReadFile("input")
	check(err)
	//fmt.Printf(string(dat))

	fmt.Printf("Part 1: %d\n", Part1(string(dat)))
	fmt.Printf("Part 2: %d\n", Part2(string(dat)))

}

func Part1(dat string) int64 {
	var total int64 = 0

	var grid [1000][1000]bool

	for _, str := range strings.Split(dat, "\r\n") {
		commands := strings.Split(str, " ")

		if len(commands) == 4 {
			startx, _ := strconv.Atoi(strings.Split(commands[1], ",")[0])
			starty, _ := strconv.Atoi(strings.Split(commands[1], ",")[1])

			endx, _ := strconv.Atoi(strings.Split(commands[3], ",")[0])
			endy, _ := strconv.Atoi(strings.Split(commands[3], ",")[1])

			for i := startx; i <= endx; i++ {
				for j := starty; j <= endy; j++ {
					grid[i][j] = !grid[i][j]
				}
			}

		} else {
			startx, _ := strconv.Atoi(strings.Split(commands[2], ",")[0])
			starty, _ := strconv.Atoi(strings.Split(commands[2], ",")[1])

			endx, _ := strconv.Atoi(strings.Split(commands[4], ",")[0])
			endy, _ := strconv.Atoi(strings.Split(commands[4], ",")[1])

			var on bool = commands[1] == "on"
			for i := startx; i <= endx; i++ {
				for j := starty; j <= endy; j++ {
					grid[i][j] = on
				}
			}

		}
	}

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] {
				total++
			}
		}
	}

	return total
}

func Part2(dat string) int64 {
	var total int64 = 0

	var grid [1000][1000]int64

	for _, str := range strings.Split(dat, "\r\n") {
		commands := strings.Split(str, " ")

		if len(commands) == 4 {
			startx, _ := strconv.Atoi(strings.Split(commands[1], ",")[0])
			starty, _ := strconv.Atoi(strings.Split(commands[1], ",")[1])

			endx, _ := strconv.Atoi(strings.Split(commands[3], ",")[0])
			endy, _ := strconv.Atoi(strings.Split(commands[3], ",")[1])

			for i := startx; i <= endx; i++ {
				for j := starty; j <= endy; j++ {
					grid[i][j] += 2
				}
			}

		} else {
			startx, _ := strconv.Atoi(strings.Split(commands[2], ",")[0])
			starty, _ := strconv.Atoi(strings.Split(commands[2], ",")[1])

			endx, _ := strconv.Atoi(strings.Split(commands[4], ",")[0])
			endy, _ := strconv.Atoi(strings.Split(commands[4], ",")[1])

			var on bool = commands[1] == "on"
			for i := startx; i <= endx; i++ {
				for j := starty; j <= endy; j++ {
					if on {
						grid[i][j]++
					} else {
						if grid[i][j] != 0 {
							grid[i][j]--
						}
					}
				}
			}

		}
	}

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			total += grid[i][j]
		}
	}

	return total
}
