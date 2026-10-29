// 이름이 입력되고 커서가 나가면(옮겨지면) span 이름에 입력한 값이 출력되기 = onBlur

import { useState } from "react";

// 직업이 입력되면서 값이 바뀌면 span 직업에 입력한 값이 출력되기 = onChange
const FuncNameJob = () => {
    const [name, setName] = useState('');
    const [job, setJob] = useState('');

    const changeJob = (e) => 
        setJob(e.target.value);
    return(
        <div>
            <input type="text" placeholder="이름을 입력하세요" onBlur={(e) => {
                setName(e.target.value);
            }}/>
            <input type="text" placeholder="직업을 입력하세요" onChange={changeJob}/>
            <br/>
            <span>이름: {name}</span><br/>
            <span>직업: {job}</span>
        </div>
    )
}

export default FuncNameJob;