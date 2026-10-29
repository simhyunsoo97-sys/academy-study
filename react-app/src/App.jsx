import { Test } from './components/01_component/ClassComponent'
import FuncComp from './components/01_component/FuncComponent'
import Button from './components/02_props/Button'
import ClassProps from './components/02_props/ClassProps'
import FuncProps from './components/02_props/FuncProps'
import ClassOneNumTwoBtn from './components/03_state/ClassOneNumTwoBtn'
import ClassState from './components/03_state/ClassState'
import FuncNameJob from './components/03_state/FuncNameJob'
import FuncOneNumTwoBtn from './components/03_state/FuncOneNumTwoBtn'
import FuncSendDelValue from './components/03_state/FuncSendDelValue'
import FuncState from './components/03_state/FuncState'
import TodoList from './components/03_state/TodoList';
// import ClassComp from './components/01_component/ClassComponent'


function App() {
  return (
    <div>
      <h1>컴포넌트 연습</h1>
      <FuncComp/>
      {/* <ClassComp/> */}
      <Test/>

      <hr/>

      <h1>props 연습</h1>
      <ClassProps color="빨강" style="청청"><span style={{backgroundColor : 'pink'}}>큐티뽀짝</span></ClassProps>
      <FuncProps today = '라면'tomorrow = '짬뽕'><mark>파스타</mark></FuncProps>
      <Button color="red" text="삭제"/>
      <Button color="blue" text="확인"/>
      <Button color="green" text="전송"/>

      <hr/>

      <h1>state연습</h1>
      <ClassState/>
      <ClassOneNumTwoBtn/>

      <hr/>

      <FuncState/>
      <br/>
      <FuncOneNumTwoBtn/>
      <FuncNameJob/>
      <FuncSendDelValue/>
      <TodoList/>
    </div>
  )
}

export default App