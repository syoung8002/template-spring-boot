forEach: Aggregate
fileName: {{namePascalCase}}Repository.java
path: {{boundedContext.name}}/{{{options.packagePath}}}/domain
---
package {{options.package}}.domain;

{{#if boundedContext.readModels}} 
import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.Query;
{{/if}}
import {{options.package}}.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel="{{namePlural}}", path="{{namePlural}}")
public interface {{namePascalCase}}Repository extends PagingAndSortingRepository<{{namePascalCase}}, {{aggregateRoot.keyFieldDescriptor.className}}>{
{{#if boundedContext.readModels}}    
    @Query(value = "select {{nameCamelCase}} " +
        "from {{namePascalCase}} {{nameCamelCase}} " +
        "where{{#boundedContext.readModels}}{{#queryParameters}}(:{{name}} is null or {{../nameCamelCase}}.{{name}} like %:%{{name}}){{^@last}} and {{/@last}}{{/queryParameters}}{{/boundedContext.readModels}}")
       List<{{namePascalCase}}> {{#boundedContext.readModels}}{{#queryOption}}{{apiPath}}{{/queryOption}}Query       
({{#queryParameters}}{{className}} {{nameCamelCase}}{{^@last}}, {{/@last}}{{/queryParameters}}, Pageable pageable);
{{/boundedContext.readModels}}
{{/if}}  
}
<function>
 var me = this;
 me.contexts.views = []
  if(this.boundedContext.readModels)
  this.boundedContext.readModels.forEach(view=>{
      if(view.aggregate == me && view.dataProjection=="query-for-aggregate"){
          me.contexts.views.push(view);
      }
  })
  window.$HandleBars.registerHelper('isNotId', function (className) {
    return (className != 'id')
  })

  window.$HandleBars.registerHelper('isText', function (className) {
    return (className.endsWith("String"))
  })

  window.$HandleBars.registerHelper('isBoolean', function (className) {
    return (className.endsWith("Boolean"))
  })

  window.$HandleBars.registerHelper('isNumber', function (className) {
    return (className.endsWith("Long") || className.endsWith("Integer"))
  })

  window.$HandleBars.registerHelper('isDate', function (className) {
    return (className.endsWith("Date"))
  })

  window.$HandleBars.registerHelper('toURL', function (className) {

    var pluralize = function(value, revert){

      var plural = {
          '(quiz)$'               : "$1zes",
          '^(ox)$'                : "$1en",
          '([m|l])ouse$'          : "$1ice",
          '(matr|vert|ind)ix|ex$' : "$1ices",
          '(x|ch|ss|sh)$'         : "$1es",
          '([^aeiouy]|qu)y$'      : "$1ies",
          '(hive)$'               : "$1s",
          '(?:([^f])fe|([lr])f)$' : "$1$2ves",
          '(shea|lea|loa|thie)f$' : "$1ves",
          'sis$'                  : "ses",
          '([ti])um$'             : "$1a",
          '(tomat|potat|ech|her|vet)o$': "$1oes",
          '(bu)s$'                : "$1ses",
          '(alias)$'              : "$1es",
          '(octop)us$'            : "$1i",
          '(ax|test)is$'          : "$1es",
          '(us)$'                 : "$1es",
          '([^s]+)$'              : "$1s"
      };

      var singular = {
          '(quiz)zes$'             : "$1",
          '(matr)ices$'            : "$1ix",
          '(vert|ind)ices$'        : "$1ex",
          '^(ox)en$'               : "$1",
          '(alias)es$'             : "$1",
          '(octop|vir)i$'          : "$1us",
          '(cris|ax|test)es$'      : "$1is",
          '(shoe)s$'               : "$1",
          '(o)es$'                 : "$1",
          '(bus)es$'               : "$1",
          '([m|l])ice$'            : "$1ouse",
          '(x|ch|ss|sh)es$'        : "$1",
          '(m)ovies$'              : "$1ovie",
          '(s)eries$'              : "$1eries",
          '([^aeiouy]|qu)ies$'     : "$1y",
          '([lr])ves$'             : "$1f",
          '(tive)s$'               : "$1",
          '(hive)s$'               : "$1",
          '(li|wi|kni)ves$'        : "$1fe",
          '(shea|loa|lea|thie)ves$': "$1f",
          '(^analy)ses$'           : "$1sis",
          '((a)naly|(b)a|(d)iagno|(p)arenthe|(p)rogno|(s)ynop|(t)he)ses$': "$1$2sis",
          '([ti])a$'               : "$1um",
          '(n)ews$'                : "$1ews",
          '(h|bl)ouses$'           : "$1ouse",
          '(corpse)s$'             : "$1",
          '(us)es$'                : "$1",
          's$'                     : ""
      };

      var irregular = {
          'move'   : 'moves',
          'foot'   : 'feet',
          'goose'  : 'geese',
          'sex'    : 'sexes',
          'child'  : 'children',
          'man'    : 'men',
          'tooth'  : 'teeth',
          'person' : 'people',
          'index'  : 'indexes'
      };

      var uncountable = [
          'sheep',
          'fish',
          'deer',
          'moose',
          'series',
          'species',
          'money',
          'rice',
          'information',
          'equipment'
      ];

      // save some time in the case that singular and plural are the same
//      console.log("value = " + value)
      if(uncountable.indexOf(value.toLowerCase()) >= 0)
      return this;

      // check for irregular forms
      for(var word in irregular){

          if(revert){
                  var pattern = new RegExp(irregular[word]+'$', 'i');
                  var replace = word;
          } else{ var pattern = new RegExp(word+'$', 'i');
                  var replace = irregular[word];
          }
          if(pattern.test(value))
              return value.replace(pattern, replace);
      }

      if(revert) var array = singular;
          else  var array = plural;

      // check for matches using regular expressions
      for(var reg in array){

          var pattern = new RegExp(reg, 'i');

          if(pattern.test(value))
              return value.replace(pattern, array[reg]);
      }

      return value;
    }

    return pluralize(className.toLowerCase())
  })

</function>
