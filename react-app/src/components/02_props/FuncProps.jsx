//컴포넌트 명이 propsEx2인 함수형 컴포넌트 생성
// "오늘먹은 음식은 김치찌개입니다" 렌더링
// + App.jsx에서 해당 컴포넌트 삽입까지 하기
//const propsEx2 = props => {
const propsEx2 = ({today, tomorrow = '우동', children}) => {
    //console.log(props)
    //const {today, tomorrow = '우동'} = props;
        return (
        <div>
            {/* <div>오늘 먹은 음식은 {props.today}입니다</div> */}
            <div>오늘 먹은 음식은 {today}입니다</div>
            <div>내일 먹을 음식은 {tomorrow}입니다</div>
            <div>어제 먹은 음식은 {children}입니다</div>
        </div>
        
    )    
}

export default propsEx2;
