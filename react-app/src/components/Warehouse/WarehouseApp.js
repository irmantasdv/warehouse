import React, { Component } from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import ProductList from '../Product/ProductList';
import CategoryList from '../Category/CtegoryList';
import Product from '../Product/Product';
import Home from '../HomePage/Home';
import Header from '../Header/Header';
import Footer from '../Footer/Footer';

class WarehouseApp extends Component {

    render() {
        return <>
            <Router>
                <>

                    <Header />
                    <Route path="/" exact component={Home} />
                    <Route path="/product/:id" exact component={Product}/>
                    <Route path="/products" component={ProductList} />
                    <Route path="/categories" component={CategoryList} />
                    <Footer />
                </>
            </Router>
        </>
    }
}
export default WarehouseApp;