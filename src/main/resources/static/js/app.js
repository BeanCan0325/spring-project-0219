document.addEventListener('DOMContentLoaded', () => {
    
    // 이벤트 위임
    document.body.addEventListener('click', (e) => {
        const target = e.target.closest('[data-action]');
        if (!target) return;
        
        const action = target.dataset.action;
        
        // 비밀번호 표시/숨김
        if (action === 'toggle-password') {
            const inputId = target.dataset.target;
            const input = document.getElementById(inputId);
            if (input.type === 'password') {
                input.type = 'text';
                target.style.opacity = '0.5';
            } else {
                input.type = 'password';
                target.style.opacity = '1';
            }
        }
        
        // 아이디 중복 확인 (더미)
        if (action === 'check-id') {
            const idInput = document.getElementById('userId');
            if (idInput.value.length >= 6) {
                alert('사용 가능한 아이디입니다.');
                idInput.classList.remove('is-invalid');
                idInput.classList.add('is-valid');
            } else {
                alert('아이디를 6자 이상 입력해주세요.');
            }
        }
    });

    // 폼 유효성 검사 (아이디, 비밀번호 위주)
    const validators = {
        userId: { regex: /^[a-zA-Z0-9]{6,20}$/, msg: "영문, 숫자 6~20자를 입력해주세요." },
        loginId: { regex: /^[a-zA-Z0-9]{4,20}$/, msg: "아이디를 정확히 입력해주세요." },
    };

    const validateInput = (input) => {
        const id = input.id;
        const val = input.value;
        const errorEl = input.nextElementSibling;
        
        if (!validators[id] && id !== 'userPasswordConfirm') return true;

        let isValid = false;

        if (id === 'userPasswordConfirm') {
            const pwd = document.getElementById('userPassword').value;
            isValid = val === pwd && val !== '';
            if (!isValid && errorEl) errorEl.textContent = "비밀번호가 일치하지 않습니다.";
        } else {
            isValid = validators[id].regex.test(val);
            if (!isValid && errorEl) errorEl.textContent = validators[id].msg;
        }

        if (isValid) {
            input.classList.remove('is-invalid');
            input.classList.add('is-valid');
        } else {
            input.classList.remove('is-valid');
            input.classList.add('is-invalid');
        }
        
        return isValid;
    };

    document.querySelectorAll('input[required]').forEach(input => {
        input.addEventListener('input', () => validateInput(input));
        input.addEventListener('blur', () => validateInput(input));
    });

    document.querySelectorAll('form').forEach(form => {
        form.addEventListener('submit', (e) => {
            let formValid = true;
            form.querySelectorAll('input[required]').forEach(input => {
                if (!validateInput(input) || input.value.trim() === '') {
                    formValid = false;
                    input.classList.add('is-invalid');
                }
            });
            if (!formValid) {
                e.preventDefault();
            }
        });
    });
});