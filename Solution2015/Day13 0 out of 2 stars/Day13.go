package main

import (
	"fmt"
	"os"
	"slices"
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
	names := make([]string, 0)

	list := make(map[string]map[string]int64)

	for _, s := range strings.Split(dat, "\r\n") {
		name := strings.Split(s, " ")[0]
		if !slices.Contains(names, name) {
			names = append(names, name)
			list[name] = make(map[string]int64)
		}
	}

	for _, s := range strings.Split(dat, "\r\n") {
		name := strings.Split(s, " ")[0]
		name2 := strings.Trim(strings.Split(s, " ")[10], ".")
		u := strings.Split(s, " ")[2]
		val, _ := strconv.ParseInt(strings.Split(s, " ")[3], 10, 64)

		if u == "lose" {
			val *= -1
		}

		list[name][name2] = val
	}

	seeting := make([]string, 0)

	happinessList := make([]int64, 0)

	seeting = append(seeting, names[0])

	for i := range names {

	}

	happinessList = append(happinessList, getHappiness(seeting, list))

	fmt.Println(happinessList)
	fmt.Println(seeting)

	return total
}

func getHappiness(seeting []string, list map[string]map[string]int64) int64 {
	var total int64 = 0
	for i := range seeting {
		//right
		if i != len(seeting)-1 {
			total += list[seeting[i]][seeting[i+1]]
		} else {
			total += list[seeting[i]][seeting[0]]
		}
		//left
		if i != 0 {
			total += list[seeting[i]][seeting[i-1]]
		} else {
			total += list[seeting[i]][seeting[len(seeting)-1]]
		}
	}
	return total
}

func Part2(dat string) int64 {
	var total int64 = 0

	return total
}
