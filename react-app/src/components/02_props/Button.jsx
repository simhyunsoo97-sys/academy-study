const Button = ({color, text}) => {
    return <button style={{color}}>{text}</button>
}

export default Button;
/*
    {color} = props; 이코드에서 color라는 변수는 'red' or 'blue' or 'green' 리터럴값만 갖고있음
    <button style={{color}}>{text}</button>     ->    <button style={'red'}>삭제</button>               (x) -- 1
                                                ->    <button style={{color: 'red'}}>삭제</button>      (o) -- 2
                                                1번의 코드처럼 들어가고 있는것은 아님!
                                                 javascript문법에 따라 축약해서 써진것
                                                        const color = 'red';
                                                        const obj = {
                                                            color: color // color: 'red'
                                                        };

                                                        ↓

                                                        const obj = {
                                                            color // 객체 축약 문법
                                                        }
 */