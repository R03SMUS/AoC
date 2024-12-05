open System
open System.IO

let intArray (stringarr: string array) =
    let intarray = Array.map int stringarr
    intarray
let part1 (texts: string array) =
    let mutable total = 0
    for text in texts do
        let mutable maxv = Int32.MinValue
        let mutable minv = Int32.MaxValue
        let newArray = intArray (text.Split([| "\t" |], StringSplitOptions.None))
        newArray |> Array.iter (fun item ->
            let i = item
            if i > maxv then
                maxv <- i 
            if i < minv then
                minv <- i
            )
        total <- total + (maxv - minv)
    total
    


let part2 (texts: string array) =
    let mutable total = 0
    for text in texts do
        let newArray = intArray (text.Split([| "\t" |], StringSplitOptions.None))
        newArray |> Array.iter (fun item ->
            let i = item
            for j in newArray do
                if i <> j && i % j = 0 then
                    total <- total + (i/j)             
            )
    total

let file = "Solution2017\\Day2\\input"
let n = File.ReadAllLines(file)

printfn $"{part1 n}"
printfn $"{part2 n}"

    

