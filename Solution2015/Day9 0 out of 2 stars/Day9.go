package main

import (
	"fmt"
	"os"
	"strings"
)

func check(e error) {
	if e != nil {
		panic(e)
	}
}

func main() {
	dat, err := os.ReadFile("input2")
	check(err)
	//fmt.Printf(string(dat))

	fmt.Printf("Part 1: %d\n", Part1(string(dat)))
	fmt.Printf("Part 2: %d\n", Part2(string(dat)))

}

type graph struct {
	vertices []vertex
}

type vertex struct {
	edge  []edge
	edges int
	name  string
}

type edge struct {
	v int8
	w int8
}

func (v *vertex) addEdge(e edge) {
	v.edge = append(v.edge, e)
	v.edges++
}

func Part1(dat string) int64 {
	var total int64 = 0

	fmt.Println(dat)
	var g = graph{}

	var citymap = make(map[string]int8)
	//populate cities.
	for _, s := range strings.Split(dat, "\r\n") {
		city := strings.Split(s, " ")[0]
		city2 := strings.Split(s, " ")[2]
		_, ok := citymap[city]
		if !ok {
			citymap[city] = int8(len(citymap))
			vertex := vertex{edge: make([]edge, 0), name: city}
			g.vertices = append(g.vertices, vertex)
		}
		_, ok = citymap[city2]
		if !ok {
			citymap[city2] = int8(len(citymap))
			vertex := vertex{edge: make([]edge, 0), name: city2}
			g.vertices = append(g.vertices, vertex)
		}

		g.vertices[citymap[city]].edge = append(g.vertices[citymap[city]].edge, edge{v: citymap[city], w: citymap[city2]})
		g.vertices[citymap[city2]].edge = append(g.vertices[citymap[city2]].edge, edge{v: citymap[city2], w: citymap[city]})

	}
	fmt.Println(g)

	fmt.Println(citymap)

	for i := range len(citymap) {
		fmt.Println(g.vertices[i])
	}

	return total
}

func Part2(dat string) int64 {
	var total int64 = 0

	return total
}
