import { useState } from "react";
import "../../App.css";
const TodoList = () => {
    const [todo, setTodo] =useState([
        {no:1, content:'Front 시험 준비', checked:false},
        {no:2, content:'JDBC 복습', checked:true},
        {no:3, content:'운동 1시간', checked:true}
    ]);


    const [inputText, setInputText] = useState('');
    const inputContent = (e) => {
        setInputText(e.target.value)
    }


    const [no, setNo] = useState(4);
    const insertTodo = () => {
        setTodo([...todo,{no:no, content:inputText, checked:false}])
        setNo(no+1);
        setInputText('');
    }

    const changeCheck = (no) => {
        setTodo(todo.map((element) => {
            return(
            element.no === no ? {...element, checked:!element.checked} : element
            )
        }));
    }

    const deleteTodo = no => {
        // filter() : 배열ㅇ의 각 요소를 돌면서 함수 실행, 조건에 맞는 요소만을 갖는 배열 리턴
        setTodo(todo.filter(element => {
            return element.no !== no;
        }));
    }

    return(
        <div className="todo">
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>할 일 내용</th>
                        <th>완료 여부</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    {todo.map(element => (
                        <tr key={element.no} style={element.checked ? {textDecoration: 'line-through'} : {}}>
                            <td>{element.no}</td>
                            <td>{element.content}</td>
                            <td onClick={() => changeCheck(element.no)}>{element.checked ? '완료' : '미완료'}</td>
                            <td><button onClick={() => deleteTodo(element.no)}>삭제</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <br/>
            <input onChange={inputContent} value={inputText}/> <button onClick={insertTodo}>할 일 등록</button>
        </div>
    )
}

export default TodoList;