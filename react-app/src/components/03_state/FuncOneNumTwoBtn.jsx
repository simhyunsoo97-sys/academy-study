import { useState } from "react"
import Button from "../02_props/Button";

const FuncOneNumTwoBtn = () => {
    const [num, setNum] = useState(0);
    const sumOne = () => {
        setNum(num+1)
    }
    return(
        <div>
            <button onClick={() => {
                setNum(num-1)   
            }}>-</button>&nbsp;&nbsp;&nbsp;
            <h2 style={{display: 'inline'}}>{num}</h2>&nbsp;&nbsp;&nbsp;
            <button onClick={sumOne}>+</button>
        </div>

    )
}

export default FuncOneNumTwoBtn; 