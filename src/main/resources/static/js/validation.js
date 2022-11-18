


function validator (options) {

    var selectorRule = {

    };

    // hàm thực hiện validate
    function validate (inputElement, rule) {
        var errorElement = inputElement.parentElement.querySelector(options.errorSelection)
        var errorMessenge = rule.test(inputElement.value)
        // lấy ra các rule của selector
        var rules = selectorRule[rule.selector]
        //lặp ra từng rule và kiểm tra
        //nếu có lỗi thì dừng việc kiểm tra
        for (var i = 0; i <= rules.length; i++) {
            errorMessenge = rules[i](inputElement.value)
            if(errorMessenge) 
                break;
            
        }
        if (errorMessenge) {
            errorElement.innerText = errorMessenge;
            inputElement.parentElement.classList.add('invalid')
        }else {
            errorElement.innerText = '';
            inputElement.parentElement.classList.remove('invalid')
        }
    }

    // lấy element của form cần validate
    var formElement = document.querySelector (options.form)
    if(formElement) {
        // bỏ hành vi mặc định của submid
        formElement.onsubmit = function(e) {
//            e.preventDefault()

            // lặp qua từng rule và validate
            options.rules.forEach (function (rule) {
                var inputElement = formElement.querySelector(rule.selector)
                var textarea = document.getElementsByTagName(textarea)
                validate (inputElement,rule,textarea);
            })
        } 

        // lặp qua mỗi rule và xử lí(lắng nghe, blur...)
        options.rules.forEach (function (rule) {
            // lưu lại các rule cho mỗi input
            if(Array.isArray(selectorRule [rule.selector])) {
                selectorRule[rule.selector].push(rule.test)
            }else {
                selectorRule [rule.selector] = [rule.test];
            }

            var inputElement = formElement.querySelector(rule.selector)
            var errorElement = inputElement.parentElement.querySelector(options.errorSelection)
            if(inputElement) {

                // xử lí trường hợp blur ra khỏi input
                inputElement.onblur = function () { 
                    validate (inputElement,rule);
                }
                // xử lí mỗi khi người dùng nhập vào input
                inputElement.oninput = function () {
                    errorElement.innerText = '';
                    inputElement.parentElement.classList.remove('invalid')
                }
            }
        })
    }
}

validator.isRequied = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined : 'vui lòng nhập trường này'
        }
    }

}

validator.isEmail = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            var regix = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/ ;
            return regix.test(value) ? undefined : 'trường này phải là Email';
        }
    }
}

validator.minLength = function (selector, min) {
    return {
        selector: selector,
        test: function (value) {
            return value.length >= min ? undefined : `phải nhập hơn ${min} kí tự`
        }
    }
}

validator.isConfirma = function (selector, getisCongimar, message) {
    return {
        selector: selector,
        test: function (value) {
            return value === getisCongimar() ? undefined : message || 'giá trị nhập vào không đúng'
        }
    }
}


validator({
    form: '#form-1',
    errorSelection: '.form-message',
    rules: [
     validator.isRequied('#fullname'),
     validator.isRequied('#phone'),
     validator.isRequied('#content'),
     validator.isRequied('#email'),
     validator.isEmail('#email'),

    ]
});









