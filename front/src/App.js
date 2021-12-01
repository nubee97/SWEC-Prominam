import Header from "./components/Header";
import { Reset } from "styled-reset";
import * as React from "react";
import Movie from "./components/Movie";
import Cinema from "./components/Cinema";
import Screen from "./components/Screen";
import Seat from "./components/Seat";
import Ticket from "./components/Ticket";
import NotFound from "./components/NotFounded";
import { BrowserRouter, Redirect, Route, Switch, Link } from "react-router-dom";
import AppStateProvider from "./providers/AppStateProvider";

function App() {
  return (
    <AppStateProvider>
      <BrowserRouter>
        <Reset />
        {/* <Switch> */}
        <Route path="/" component={Header}></Route>
        <Route path="/" exact component={Movie}></Route>
        <Route path="/seat" exact component={Seat}></Route>
        <Route path="/screen" exact component={Screen}></Route>
        <Route path="/cinema" exact component={Cinema}></Route>
        <Route path="/ticket" exact component={Ticket}></Route>
        {/* <Route component={NotFound}></Route> */}
        {/* </Switch> */}
      </BrowserRouter>
    </AppStateProvider>
  );
}

export default App;
