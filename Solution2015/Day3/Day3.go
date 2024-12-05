package main

import (
	"fmt"
	"os"
	"slices"
)

func check(e error) {
	if e != nil {
		panic(e)
	}
}

type xy struct {
	x int
	y int
}

func (xy *xy) incrementY() {
	xy.y++
}
func (xy *xy) incrementX() {
	xy.x++
}
func (xy *xy) decrementY() {
	xy.y--
}
func (xy *xy) decrementX() {
	xy.x--
}

func main() {
	dat, err := os.ReadFile("input")
	check(err)

	//fmt.Printf(string(dat))

	fmt.Printf("Part 1: %d\n", Part1(string(dat)))
	fmt.Printf("Part 2: %d\n", Part2(string(dat)))

}

func Part1(dat string) int64 {
	var total int64 = 1
	hm := make(map[int][]int)

	xy := xy{x: 0, y: 0}

	hm[xy.x] = []int{xy.y}

	for _, s := range dat {
		if s == '^' {
			xy.incrementY()
		} else if s == '>' {
			xy.incrementX()
		} else if s == 'v' {
			xy.decrementY()
		} else if s == '<' {
			xy.decrementX()
		}
		if !slices.Contains(hm[xy.x], xy.y) {
			total++
			hm[xy.x] = append(hm[xy.x], xy.y)
		}
	}
	return total
}

func Part2(dat string) int64 {
	var total int64 = 1
	hm := make(map[int][]int)

	santa := xy{x: 0, y: 0}
	robo := xy{x: 0, y: 0}

	hm[0] = []int{0}

	for i, s := range dat {
		if (i % 2) == 0 {
			id(&santa, s)
			if !slices.Contains(hm[santa.x], santa.y) {
				total++
				hm[santa.x] = append(hm[santa.x], santa.y)
			}
		} else {
			id(&robo, s)
			if !slices.Contains(hm[robo.x], robo.y) {
				total++
				hm[robo.x] = append(hm[robo.x], robo.y)
			}
		}

	}
	return total
}

func id(xy *xy, s int32) {
	if s == '^' {
		xy.incrementY()
	} else if s == '>' {
		xy.incrementX()
	} else if s == 'v' {
		xy.decrementY()
	} else if s == '<' {
		xy.decrementX()
	}
}
