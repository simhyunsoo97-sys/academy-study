// 컴포넌트 명이 propsEx1인 클래스형 컴포넌트 생성
// 렌더링할 화면은 div 태그 안에 "오늘의 포인트 컬러는 레드입니다"
import { Component } from "react";

class propsEx1 extends Component{
    //static defaultProps = {style: '올화이트'};
    render(){
        console.log(this.props)
        //console.log(this.props.color)
        const {color, style, children} = this.props; // 객체에서 꺼내는 구조분해할당
        const dressCode = this.props.children;
        return(
            <div>
                <div>오늘의 포인트 컬러는 {color}입니다</div>
                <div>내일의 코디는 {style}입니다</div>
                <div>주말 약속 드레스 코드는 {children}입니다</div>
            </div>        
        )
    }
}

propsEx1.defaultProps = {style:'올블랙'};

export default propsEx1;