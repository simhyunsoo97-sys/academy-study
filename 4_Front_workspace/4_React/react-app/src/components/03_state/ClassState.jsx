import { Component } from 'react'

// 클래스 컴포넌트 생성 과정에 속하는 생명주기 함수
// : render(), constructor(), getDerivedStateFromProps(), componentDidMount()
// -> render() : 코드를 화면에 그려주는 함수
// -> constructor() :  생명주기 함수 중 가장 먼저 실행하면서 처음 한 번만 실행
//                     변수 state를 선언하고 부모에게 전달받은 props를 초기화할때 사용
//                     (super()는 반드시 가장 위에 호출하며 생성자 매개변수 props필수)
class ClassState extends Component{
    constructor(props){
        super(props);
        this.state = {number1:0, number2:0} // state 선언 및 초기화

    }

    render(){
        console.log(this.state);
        const {number1,number2} = this.state;
        return (
            <div>
                <h2>{number1}</h2>
                <button onClick={() => {
                    this.setState({number1:number1+1})
                }}>Click Me!</button>{/* 함수 직접 삽입 */}
                <h2>{number2}</h2>
                <button onClick={this.number2SubOne}>Click Me!</button>{/* 함수 선언 삽입 */}
            </div>
        )
    }

    number2SubOne = () => {
        this.setState({number2:this.state.number2-1})
    }
}

export default ClassState;