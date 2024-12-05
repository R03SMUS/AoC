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
	/*
		children: 3
		cats: 7
		samoyeds: 2
		pomeranians: 3
		akitas: 0
		vizslas: 0
		goldfish: 5
		trees: 3
		cars: 2
		perfumes: 1
	*/

	itemmap := make(map[string]int)
	itemmap["children"] = 3
	itemmap["cats"] = 7
	itemmap["samoyeds"] = 2
	itemmap["pomeranians"] = 3
	itemmap["akitas"] = 0
	itemmap["vizslas"] = 0
	itemmap["goldfish"] = 5
	itemmap["trees"] = 3
	itemmap["cars"] = 2
	itemmap["perfumes"] = 1

	var total int64 = 0
	//fmt.Println(dat)
	for _, s := range strings.Split(dat, "\r\n") {

		ballspoop := strings.SplitN(s, ":", 2)

		name := ballspoop[0]
		//fmt.Println(name)

		strings.Trim(ballspoop[1], " ")

		var fit bool = true

		for _, l := range strings.Split(ballspoop[1], ",") {
			items := strings.Split(strings.Trim(l, " "), ": ")
			//fmt.Println(items[0]) //item
			//fmt.Println(items[1]) //amount
			amount, _ := strconv.ParseInt(items[1], 10, 64)
			if itemmap[items[0]] != int(amount) {
				fit = false
			}
		}
		if fit {
			fmt.Println(fit, name)
		}

	}
	return total
}

func Part2(dat string) int64 {
	/*
		children: 3
		cats: 7
		samoyeds: 2
		pomeranians: 3
		akitas: 0
		vizslas: 0
		goldfish: 5
		trees: 3
		cars: 2
		perfumes: 1
	*/

	itemmap := make(map[string]int)
	itemmap["children"] = 3
	itemmap["cats"] = 7
	itemmap["samoyeds"] = 2
	itemmap["pomeranians"] = 3
	itemmap["akitas"] = 0
	itemmap["vizslas"] = 0
	itemmap["goldfish"] = 5
	itemmap["trees"] = 3
	itemmap["cars"] = 2
	itemmap["perfumes"] = 1

	var total int64 = 0
	//fmt.Println(dat)
	for _, s := range strings.Split(dat, "\r\n") {

		ballspoop := strings.SplitN(s, ":", 2)

		name := ballspoop[0]
		//fmt.Println(name)

		strings.Trim(ballspoop[1], " ")

		var fit bool = true

		for _, l := range strings.Split(ballspoop[1], ",") {
			items := strings.Split(strings.Trim(l, " "), ": ")
			//fmt.Println(items[0]) //item
			//fmt.Println(items[1]) //amount
			amount, _ := strconv.ParseInt(items[1], 10, 64)
			if items[0] == "cats" || items[0] == "trees" {
				if itemmap[items[0]] > int(amount) {
					fit = false
				}
			} else if items[0] == "pomeranians" || items[0] == "goldfish" {
				if itemmap[items[0]] < int(amount) {
					fit = false
				}
			} else {
				if itemmap[items[0]] != int(amount) {
					fit = false
				}
			}

		}
		if fit {
			fmt.Println(fit, name)
		}

	}
	return total
}
