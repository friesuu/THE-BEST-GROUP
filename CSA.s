section .data
    msg db ' ', 0      ; Message to print space

section .bss
    count resb 1       ; Reserve 1 byte for count

section .text
    global _start

_start:
    mov ecx, 8        ; Initialize ECX with 8

outer_loop:
    mov esi, ecx      ; Move current value of ECX to ESI (start number for inner loop)
    mov ebx, 1        ; Initialize EBX to 1 (counter for inner loop)

inner_loop:
    ; Convert number to ASCII and print
    add esi, '0'
    mov [count], esi
    sub esi, '0'

    ; Print the number
    mov eax, 4        ; sys_write
    mov ebx, 1        ; file descriptor 1 (stdout)
    lea ecx, [count]  ; Address of the number to print
    mov edx, 1        ; Number of bytes to write
    int 0x80          ; Call kernel

    ; Print a space
    mov eax, 4        ; sys_write
    mov ebx, 1        ; file descriptor 1 (stdout)
    lea ecx, [msg]    ; Address of the space to print
    mov edx, 1        ; Number of bytes to write
    int 0x80          ; Call kernel

    ; Increment and check if we need to loop again
    inc esi
    inc ebx
    cmp ebx, 9        ; Compare EBX with 9 (if equal, break inner loop)
    jl inner_loop     ; Jump to inner_loop if less

    ; Print newline
    mov eax, 4        ; sys_write
    mov ebx, 1        ; file descriptor 1 (stdout)
    mov ecx, msg      ; Address of the newline to print
    mov edx, 1        ; Number of bytes to write
    int 0x80          ; Call kernel

    ; Decrement ECX and check if we need to loop again
    dec ecx
    jnz outer_loop    ; Jump to outer_loop if not zero

    ; Exit the program
    mov eax, 1        ; sys_exit
    xor ebx, ebx      ; Return code 0
    int 0x80          ; Call kernel