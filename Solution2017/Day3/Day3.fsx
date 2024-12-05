open System
open System.IO

let getSecond (x: int array) =
    let sortedNumbers = Array.sortBy (fun x -> x) x
    sortedNumbers.[1]

let part1 (n) =
    let mutable bool = true
    let mutable i = 1
    let myArray = [|0;0;0;0;0|]
    while bool do
        if i % 2 <> 0 && i <> 1 && n >= (float(i-2)**2)+1.0 &&  n <= float(i)**2 then
            bool <- false
            let max = float(i)**2
            let minus = float (i-1)
            for j in {0..4} do
                let x = int(Math.Abs((max-(minus*float(j))) - n))
                myArray.[j] <- x    
        else
            i <- i + 1
    let tal = getSecond myArray
    tal


    

let part2 n =
    let mutable total = 0
    
    total
let n = 368078

printfn $"Part 1: {part1 n}"
printfn $"{part2 n}"

    

