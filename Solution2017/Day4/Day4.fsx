open System
open System.IO

let intArray (stringarr: string array) =
    let intarray = Array.map int stringarr
    intarray
let part1 (texts: string array) =
    let mutable total = 0
    for text in texts do
        let mutable bool = true
        let mutable map = Map.empty
        let passwords = text.Split ' '
        for password in passwords do
            if map.ContainsKey password then
                bool <- false
            else
                map <- map.Add(password, 1)
        if bool then
            total <- total + 1  
    total
    


let part2 (texts: string array) =
    let mutable total = 0
    total

let file = "Solution2017\\Day4\\input"
let n = File.ReadAllLines(file)

printfn $"{part1 n}"
printfn $"{part2 n}"

    

