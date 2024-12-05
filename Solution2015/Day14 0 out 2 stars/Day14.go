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

	dlist := make([]int64, 0)

	for _, s := range strings.Split(dat, "\r\n") {
		list := strings.Split(s, " ")

		kmt := list[3]
		s := list[6]
		reset := list[13]

		dlist = append(dlist, getDistance(kmt, s, reset, 2503))
	}

	var maxdistance int64 = 0

	for _, d := range dlist {
		if d > maxdistance {
			maxdistance = d
		}
	}

	return maxdistance

}

func getDistance(kmt string, s string, reset string, timeinput int64) int64 {

	var kmtINT, _ = strconv.ParseInt(kmt, 10, 64)
	var sINT, _ = strconv.ParseInt(s, 10, 64)
	var resetINT, _ = strconv.ParseInt(reset, 10, 64)

	var km int64
	var time int64 = timeinput

	for time > 0 {
		if time > sINT {
			km += kmtINT * sINT
		} else {
			km -= kmtINT * time
		}
		time -= sINT
		time -= resetINT
	}

	return km

}

func getDistanceWithHest(hest hest, timeinput int) int64 {
	var kmtINT = hest.kmt
	var sINT = hest.s
	var resetINT = hest.reset

	//fmt.Println(kmtINT, sINT, resetINT)

	var km int64
	var time int64 = int64(timeinput)

	for time > 0 {
		if time > sINT {
			km += kmtINT * sINT
		} else {
			km += kmtINT * time
		}
		time -= sINT
		time -= resetINT
	}

	return km
}

type hest struct {
	kmt   int64
	s     int64
	reset int64
}

func Part2(dat string) int64 {
	var total int64 = 0

	distancemap := make(map[string][]int64)
	pointmap := make(map[string]int64)

	for _, s := range strings.Split(dat, "\r\n") {
		list := strings.Split(s, " ")

		name := list[0]
		kmt, _ := strconv.ParseInt(list[3], 10, 64)
		s, _ := strconv.ParseInt(list[6], 10, 64)
		reset, _ := strconv.ParseInt(list[13], 10, 64)

		hest := hest{kmt, s, reset}
		for i := range 2504 {
			if i == 0 {
				continue
			}
			distancemap[name] = append(distancemap[name], getDistanceWithHest(hest, i))
		}
	}
	for i := range 2503 {
		var m int64 = 0
		for k, _ := range distancemap {
			if m < distancemap[k][i] {
				m = distancemap[k][i]
			}
		}
		for k, _ := range distancemap {
			if distancemap[k][i] == m {
				pointmap[k]++
			}
		}

	}

	//find lige selv max, der er 6 lol
	fmt.Println(pointmap)

	return total
}
