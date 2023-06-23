path: frontend/src
---

import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


{{#boundedContexts}}
    {{#aggregates}}
        {{#if uiStyle.layout}}
import {{namePascalCase}}Manager from "./components/listers/{{namePascalCase}}{{#layoutPascalCase uiStyle.layout}}{{/layoutPascalCase}}"
        {{else}}
import {{namePascalCase}}Manager from "./components/listers/{{namePascalCase}}Cards"
        {{/if}}
import {{namePascalCase}}Detail from "./components/listers/{{namePascalCase}}Detail"
    {{/aggregates}}

    {{#viewes}}
import {{namePascalCase}}View from "./components/{{namePascalCase}}View"
import {{namePascalCase}}ViewDetail from "./components/{{namePascalCase}}ViewDetail"
    {{/viewes}}
{{/boundedContexts}}

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
       {{#boundedContexts}}
        {{#aggregates}}
            {
                path: '/{{namePlural}}',
                name: '{{namePascalCase}}Manager',
                component: {{namePascalCase}}Manager
            },
            {
                path: '/{{namePlural}}/:id',
                name: '{{namePascalCase}}Detail',
                component: {{namePascalCase}}Detail
            },
        {{/aggregates}}

        {{#viewes}}
            {
                path: '/{{namePlural}}',
                name: '{{namePascalCase}}View',
                component: {{namePascalCase}}View
            },
            {
                path: '/{{namePlural}}/:id',
                name: '{{namePascalCase}}ViewDetail',
                component: {{namePascalCase}}ViewDetail
            },
        {{/viewes}}
       {{/boundedContexts}}


    ]
})

<function>
    window.$HandleBars.registerHelper('layoutPascalCase', function (layout) {
        let layoutPas = layout.toLowerCase();
        layoutPas = layoutPas.charAt(0).toUpperCase();
        try{
            if(layout=='CARD'){
                return layoutPas+'s'
            } else if(layout=='LIST'){
                return layoutPas
            } else if(layout=='TABLE'){
                return layoutPas
            } else{
                return layoutPas
            }
        }catch(e){
            console.log(e);
        }
    })
</function>
