import { useState } from "react";

const FuncSendDelValue = () => {
    const [value, setValue] =useState('');
    const [text, setText] = useState('값 입력 후 버튼을 눌러주세요');


    return (
        <div>
            <h1>{text}</h1>
            <input onChange={e => setValue(e.target.value)}/><br/><br/>
            <button onClick={() => setText(value)}>값 전달</button>&nbsp;
            <button onClick={() => setText('')}>값 삭제</button>
        </div>
    )
}

export default FuncSendDelValue;