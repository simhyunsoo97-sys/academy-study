import { useState } from "react";

const FuncState = () => {
    const [number1, setNumber1] = useState(0);
    const [number2, steNumber2] = useState(0);

    const number2SubOne =() => {
        steNumber2(number2-1)
    }
    return(
        <div>
            <h1>{number1}</h1>
            <button onClick={() => {
                setNumber1(number1+1);
            }}>Click Me!</button>
            <h1>{number2}</h1>
            <button onClick={number2SubOne}>Click Me!</button>
        </div>
    )
}

export default FuncState;